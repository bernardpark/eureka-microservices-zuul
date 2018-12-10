package com.bpark.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;


public class PreFilter extends ZuulFilter {
	
	Logger logger = LoggerFactory.getLogger( PreFilter.class );


	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 100;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info( String.format( "%s request to %s", request.getMethod(), request.getRequestURL().toString() ) );

		return null;
	}
	
}