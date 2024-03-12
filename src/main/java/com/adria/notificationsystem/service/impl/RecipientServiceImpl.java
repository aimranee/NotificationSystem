package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.dto.response.RecipientResponseDto;
import com.adria.notificationsystem.mapper.EventMapper;
import com.adria.notificationsystem.mapper.RecipientMapper;
import com.adria.notificationsystem.models.Event;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.EventRepository;
import com.adria.notificationsystem.repository.RecipientRepository;
import com.adria.notificationsystem.service.RecipientService;
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
        return null;
    }
}
