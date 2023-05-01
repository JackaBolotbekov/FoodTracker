package com.example.domain.usecases

import com.example.domain.repositories.DefaultKcalRepository
import com.example.domain.repositories.SingleShowLogInRepository
import javax.inject.Inject

class SaveDefaultKcalUseCase @Inject constructor(
    private val defaultKcalRepository: DefaultKcalRepository
) {

    var defaultKcalText: String?
        get() = defaultKcalRepository.defaultKcalText
        set(value) {
            defaultKcalRepository.defaultKcalText = value
        }

    var progressKcal: Int
        get() = defaultKcalRepository.progressKcal
        set(value) {
            defaultKcalRepository.progressKcal = value
        }
}