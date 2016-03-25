package org.epilike.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import eu.epitech.epilike.thrift.EpiLikeService;

/**
 * Hello world!
 *
 */
public class App {

	public static EpiLikeServiceImpl handler;

	public static EpiLikeService.Processor<EpiLikeService.Iface> processor;

	public static void main(String[] args) {
		try {
			handler = new EpiLikeServiceImpl();
			processor = new EpiLikeService.Processor<EpiLikeService.Iface>(handler);

			Runnable simple = new Runnable() {
				public void run() {
					simple(processor);
				}

			};

			new Thread(simple).start();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public static void simple(EpiLikeService.Processor<EpiLikeService.Iface> processor) {
		try {
			TServerTransport serverTransport = new TServerSocket(9090);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

			System.out.println("Starting the simple server...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
