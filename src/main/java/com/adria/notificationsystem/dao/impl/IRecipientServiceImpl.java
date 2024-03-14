package com.adria.notificationsystem.dao.impl;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.mapper.RecipientMapper;
import com.adria.notificationsystem.model.entities.Recipient;
import com.adria.notificationsystem.repository.RecipientRepository;
import com.adria.notificationsystem.dao.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {

    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    @Override
    public Recipient save(RecipientRequestDto eventRequestDto) {
        Recipient recipient = recipientMapper.toEntity(eventRequestDto);
        if (recipientRepository.existsByEmail(recipient.getEmail())) {
            throw new DataIntegrityViolationException("An recipient with the same email already exists.");
        }
        return recipientRepository.save(recipient);
    }

    @Override
    public Recipient update(RecipientRequestDto recipient) {
        return null;
    }

    @Override
    public void delete(RecipientRequestDto recipient) {

    }

    @Override
    public Recipient findByEmail(String email) {
        if (!recipientRepository.existsByEmail(email)) {
            throw new DataIntegrityViolationException("doesn't exists.");
        }
        return recipientRepository.findByEmail(email);
    }
}
