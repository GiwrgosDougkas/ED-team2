package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProducerServiceImpl implements ProducerService {

}
