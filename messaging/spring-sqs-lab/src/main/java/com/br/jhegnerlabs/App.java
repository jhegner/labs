package com.br.jhegnerlabs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;

public class App {

    public static void main(String[] args) {

        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        ListQueuesResult lqResult = sqs.listQueues();
        System.out.println("Lista de Filas SQS configuradas");
        for(String url : lqResult.getQueueUrls()) {
            System.out.println(url);
        }

    }

}
