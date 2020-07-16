package com.zoo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;

public class ZookeeperLoadBalancer {

	public void register() {
		CuratorFramework curator = CuratorFrameworkFactory.newClient("149.165.156.200:2181", new RetryNTimes(3, 3000));
		curator.start();

		try {
			final ServiceInstance<Object> serviceInstance = ServiceInstance.builder()
					.uriSpec(new UriSpec("{scheme}://{address}:{port}"))
					.address("129.114.16.169").port(8912)
					.name("geolocon")
					.build();

			final ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class)
					.basePath("com.microservices")
					.client(curator)
					.thisInstance(serviceInstance)
					.build();

			serviceDiscovery.start();

			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				try {
					serviceDiscovery.unregisterService(serviceInstance);
				} catch (Exception e) {
					System.err.println("Error while unregistering service in Zookeeper. Details: " + e.getMessage());
					e.printStackTrace();
				}
			}));
		} catch (Exception e) {
			System.err.println("Error while registering service in Zookeeper. Details: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
