/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.transaction.annotation;

import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.Nullable;
import org.springframework.transaction.interceptor.NoRollbackRuleAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;

/**
 * Strategy implementation for parsing Spring's {@link Transactional} annotation.
 *
 * @author Juergen Hoeller
 * @since 2.5
 */
@SuppressWarnings("serial")
public class SpringTransactionAnnotationParser implements TransactionAnnotationParser, Serializable {

	/**
	 * 解析事务注解
	 * @param ae the annotated method or class
	 * @return
	 */
	@Override
	@Nullable
	public TransactionAttribute parseTransactionAnnotation(AnnotatedElement ae) {
		// 解析事务注解中的配置信息
		AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
				ae, Transactional.class, false, false);
		if (attributes != null) {
			// 包装成TransactionAnnotation
			return parseTransactionAnnotation(attributes);
		}
		else {
			return null;
		}
	}

	public TransactionAttribute parseTransactionAnnotation(Transactional ann) {
		return parseTransactionAnnotation(AnnotationUtils.getAnnotationAttributes(ann, false, false));
	}

	/**
	 * 解析事务注解的信息包装成RuleBasedTransactionAttribute
	 * @param attributes
	 * @return
	 */
	protected TransactionAttribute parseTransactionAnnotation(AnnotationAttributes attributes) {
		RuleBasedTransactionAttribute rbta = new RuleBasedTransactionAttribute();
		// 解析propagation
		Propagation propagation = attributes.getEnum("propagation");
		rbta.setPropagationBehavior(propagation.value());
		// 解析isolation
		Isolation isolation = attributes.getEnum("isolation");
		rbta.setIsolationLevel(isolation.value());
		// 解析timeout
		rbta.setTimeout(attributes.getNumber("timeout").intValue());
		// 解析readOnly
		rbta.setReadOnly(attributes.getBoolean("readOnly"));
		// 解析value
		rbta.setQualifier(attributes.getString("value"));
		ArrayList<RollbackRuleAttribute> rollBackRules = new ArrayList<>();
		// 解析rollbackFor
		Class<?>[] rbf = attributes.getClassArray("rollbackFor");
		for (Class<?> rbRule : rbf) {
			RollbackRuleAttribute rule = new RollbackRuleAttribute(rbRule);
			rollBackRules.add(rule);
		}
		// 解析rollbackForClassName
		String[] rbfc = attributes.getStringArray("rollbackForClassName");
		for (String rbRule : rbfc) {
			RollbackRuleAttribute rule = new RollbackRuleAttribute(rbRule);
			rollBackRules.add(rule);
		}
		// 解析noRollbackFor
		Class<?>[] nrbf = attributes.getClassArray("noRollbackFor");
		for (Class<?> rbRule : nrbf) {
			NoRollbackRuleAttribute rule = new NoRollbackRuleAttribute(rbRule);
			rollBackRules.add(rule);
		}
		// 解析noRollbackForClassName
		String[] nrbfc = attributes.getStringArray("noRollbackForClassName");
		for (String rbRule : nrbfc) {
			NoRollbackRuleAttribute rule = new NoRollbackRuleAttribute(rbRule);
			rollBackRules.add(rule);
		}
		rbta.getRollbackRules().addAll(rollBackRules);
		return rbta;
	}

	@Override
	public boolean equals(Object other) {
		return (this == other || other instanceof SpringTransactionAnnotationParser);
	}

	@Override
	public int hashCode() {
		return SpringTransactionAnnotationParser.class.hashCode();
	}

}
