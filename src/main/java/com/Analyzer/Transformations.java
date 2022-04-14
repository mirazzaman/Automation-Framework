package com.Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class Transformations implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstractor, Method testMethod) {
		annotation.setRetryAnalyzer(ReTryAnalyzer.class);		
	}
}