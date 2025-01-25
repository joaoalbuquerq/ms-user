package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    //RabbitTemplate basicamente é a
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    //Pq preciso do nome da fila no produtor ?
    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publicarMensagemNaFila(UserModel model){
        var emailDto = new EmailDto();
        emailDto.setUserId(model.getUserId());
        emailDto.setEmailDestino(model.getEmail());
        emailDto.setTitulo("Cadastro realizado com sucesso!");
        emailDto.setConteudo("Olá" + model.getNome() + "Seja bem vindo a nossa plataforma!");

        //É passado na exchange a string vazia por conta de ser a forma padrão do AMQP na exchange default
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
