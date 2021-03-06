package net.consensys.kafkadl.internal.failure;

import lombok.AllArgsConstructor;
import net.consensys.kafkadl.internal.forwarder.ErrorTopicForwarder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ErrorHandler;

@AllArgsConstructor
public class SendToErrorTopicErrorHandler implements ErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SendToErrorTopicErrorHandler.class);
    private ErrorTopicForwarder errorTopicForwarder;

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
        errorTopicForwarder.forward(data);
    }
}
