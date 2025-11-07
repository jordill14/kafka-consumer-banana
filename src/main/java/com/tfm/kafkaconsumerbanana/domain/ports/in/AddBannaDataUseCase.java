package com.tfm.kafkaconsumerbanana.domain.ports.in;

public interface AddBannaDataUseCase {
    void execute(String message, String token);
}
