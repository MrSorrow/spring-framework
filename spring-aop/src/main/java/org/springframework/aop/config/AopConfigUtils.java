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

package org.springframework.aop.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Utility class for handling registration of AOP auto-proxy creators.
 *
 * <p>Only a single auto-proxy creator can be registered yet multiple concrete
 * implementations are available. Therefore this class wraps a simple escalation
 * protocol, allowing classes to request a particular auto-proxy creator and know
 * that class, {@code or a subclass thereof}, will eventually be resident
 * in the application context.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @since 2.5
 * @see AopNamespaceUtils
 */
public abstract class AopConfigUtils {

	/**
	 * （内部管理的）自动代理创建者的bean名称。The bean name of the internally managed auto-proxy creator.
	 */
	public static final String AUTO_PROXY_CREATOR_BEAN_NAME =
			"org.springframework.aop.config.internalAutoProxyCreator";

	/**
	 * Stores the auto proxy creator classes in escalation order.
	 */
	private static final List<Class<?>> APC_PRIORITY_LIST = new ArrayList<>();

	/**
	 * 初始化升级列表，也就是优先权列表，index越大，优先权越高
	 */
	static {
		APC_PRIORITY_LIST.add(InfrastructureAdvisorAutoProxyCreator.class);
		APC_PRIORITY_LIST.add(AspectJAwareAdvisorAutoProxyCreator.class);
		APC_PRIORITY_LIST.add(AnnotationAwareAspectJAutoProxyCreator.class);
	}


	@Nullable
	public static BeanDefinition registerAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry) {
		return registerAutoProxyCreatorIfNecessary(registry, null);
	}

	/**
	 * 注册或升级AutoProxyCreator定义beanName为org.Springframework.aop.config.internalAutoProxyCreator的BeanDefinition
	 * bean的class为InfrastructureAdvisorAutoProxyCreator类型
	 * @param registry
	 * @param source
	 * @return
	 */
	@Nullable
	public static BeanDefinition registerAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry,
			@Nullable Object source) {

		return registerOrEscalateApcAsRequired(InfrastructureAdvisorAutoProxyCreator.class, registry, source);
	}

	@Nullable
	public static BeanDefinition registerAspectJAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry) {
		return registerAspectJAutoProxyCreatorIfNecessary(registry, null);
	}

	@Nullable
	public static BeanDefinition registerAspectJAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry,
			@Nullable Object source) {

		return registerOrEscalateApcAsRequired(AspectJAwareAdvisorAutoProxyCreator.class, registry, source);
	}

	@Nullable
	public static BeanDefinition registerAspectJAnnotationAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry) {
		return registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry, null);
	}

	/**
	 * 注册或升级AutoProxyCreator定义beanName为org.Springframework.aop.config.internalAutoProxyCreator的BeanDefinition
	 * @param registry
	 * @param source
	 * @return
	 */
	@Nullable
	public static BeanDefinition registerAspectJAnnotationAutoProxyCreatorIfNecessary(BeanDefinitionRegistry registry,
			@Nullable Object source) {

		return registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
	}

	/**
	 * 设置proxy-target-class为true调用此方法，强制使用cglib进行动态代理
	 * @param registry
	 */
	public static void forceAutoProxyCreatorToUseClassProxying(BeanDefinitionRegistry registry) {
		if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
			BeanDefinition definition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
			definition.getPropertyValues().add("proxyTargetClass", Boolean.TRUE);
		}
	}

	/**
	 * 设置expose-proxy为true，暴露动态代理对象进入ThreadLocal，便于增强方法中调用增强方法
	 * @param registry
	 */
	public static void forceAutoProxyCreatorToExposeProxy(BeanDefinitionRegistry registry) {
		if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
			BeanDefinition definition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
			definition.getPropertyValues().add("exposeProxy", Boolean.TRUE);
		}
	}

	/**
	 * 注册或者升级name为org.springframework.aop.config.internalAutoProxyCreator，类型为AnnotationAwareAspectJAutoProxyCreator的bean
	 * 升级主要是指如果已经存在name是上面的bean但类型不一样，则比较类型的优先级，优先级比AnnotationAwareAspectJAutoProxyCreator低，
	 * 则要更改beanDefinition对应的class属性为AnnotationAwareAspectJAutoProxyCreator，优先级不低则保持原样。
	 * @param cls
	 * @param registry
	 * @param source
	 * @return
	 */
	@Nullable
	private static BeanDefinition registerOrEscalateApcAsRequired(Class<?> cls, BeanDefinitionRegistry registry,
			@Nullable Object source) {
		Assert.notNull(registry, "BeanDefinitionRegistry must not be null");

		// 如果beanDefinitionMap已经存在了name为org.springframework.aop.config.internalAutoProxyCreator的自动代理创建器
		// 且存在的自动代理创建器与现在的不一致那么需要根据优先级来判断到底需要使用哪个 TODO: 优先级是啥？
		if (registry.containsBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME)) {
			// 存在就获取name为org.springframework.aop.config.internalAutoProxyCreator的beanDefinition
			BeanDefinition apcDefinition = registry.getBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME);
			// 先进行类型验证，检验beanDefinition类型是不是AnnotationAwareAspectJAutoProxyCreator
			if (!cls.getName().equals(apcDefinition.getBeanClassName())) {
				// 不是才去比较两种类型的优先级，进而判断是否升级——也就是替换class属性
				int currentPriority = findPriorityForClass(apcDefinition.getBeanClassName());
				int requiredPriority = findPriorityForClass(cls);
				// 如果AnnotationAwareAspectJAutoProxyCreator的优先级比原来的高，要进行更改。
				// （其实AnnotationAwareAspectJAutoProxyCreator已经是最高，但是cls并不一定是AnnotationAwareAspectJAutoProxyCreator，只是这里AOP分析的是）
				if (currentPriority < requiredPriority) {
					// 改变bean最重要的就是改变bean所对应的className属性
					apcDefinition.setBeanClassName(cls.getName());
				}
			}
			// 如果已经存在自动代理创建器的beanDefinition，并且类型也一致，那么无需再次创建
			return null;
		}

		// 如果不存在org.springframework.aop.config.internalAutoProxyCreator名称的BeanDefinition，则创建并注册
		RootBeanDefinition beanDefinition = new RootBeanDefinition(cls);
		beanDefinition.setSource(source);
		beanDefinition.getPropertyValues().add("order", Ordered.HIGHEST_PRECEDENCE);  // Order越小，优先级越高
		// 标注该类的角色为基础设施
		beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		// 在容器中注册beanDefinition
		registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);
		return beanDefinition;
	}

	private static int findPriorityForClass(Class<?> clazz) {
		return APC_PRIORITY_LIST.indexOf(clazz);
	}

	private static int findPriorityForClass(@Nullable String className) {
		for (int i = 0; i < APC_PRIORITY_LIST.size(); i++) {
			Class<?> clazz = APC_PRIORITY_LIST.get(i);
			if (clazz.getName().equals(className)) {
				return i;
			}
		}
		throw new IllegalArgumentException(
				"Class name [" + className + "] is not a known auto-proxy creator class");
	}

}
