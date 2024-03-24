package com.adria.notification.dao.impl;

import com.adria.notification.dto.request.RecipientRequestDto;
import com.adria.notification.mappers.RecipientMapper;
import com.adria.notification.models.entities.Recipient;
import com.adria.notification.repositories.RecipientRepository;
import com.adria.notification.dao.IRecipientDao;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IRecipientDaoImpl implements IRecipientDao {

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

    @Override
    public Recipient findByPhone(String email) {
        if (!recipientRepository.existsByEmail(email)) {
            throw new DataIntegrityViolationException("doesn't exists.");
        }
        return recipientRepository.findByEmail(email);
    }
}
