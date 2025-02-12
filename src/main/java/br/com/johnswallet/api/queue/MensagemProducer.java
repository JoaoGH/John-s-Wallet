package br.com.johnswallet.api.queue;

import br.com.johnswallet.api.config.RabbitMQConfig;
import br.com.johnswallet.api.dto.MensagemDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarMensagem(MensagemDTO dto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, dto);
    }

}
