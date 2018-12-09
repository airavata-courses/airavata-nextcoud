package com.microservices.nextcloudzk.lb;

import java.net.URI;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceProvider;

public class NextcloudServiceDiscovery {

	private static ServiceProvider<Object> nextcloudServiceProvider;

	private static ServiceProvider<Object> getNextcloudServiceProvider() throws Exception {
		if(nextcloudServiceProvider == null) {
			CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("149.165.156.200:2181", new RetryNTimes(5, 1000));
			curatorFramework.start();

			ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class)
					.basePath("com.microservices")
					.client(curatorFramework)
					.build();
			serviceDiscovery.start();

			nextcloudServiceProvider = serviceDiscovery.serviceProviderBuilder()
					.serviceName("geolocon")
					.build();
			nextcloudServiceProvider.start();
		}
		return nextcloudServiceProvider;
	}

	public static URI getGeolocationServiceUri() throws Exception {
		return new URI(getNextcloudServiceProvider().getInstance().buildUriSpec());
	}
}
