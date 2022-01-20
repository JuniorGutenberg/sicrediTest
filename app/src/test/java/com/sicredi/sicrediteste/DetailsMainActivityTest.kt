package com.sicredi.sicrediteste

import com.sicredi.sicrediteste.view.activity.DetailsMainActivity
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.MockitoAnnotations


class DetailsMainActivityTest {
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun isValidEmailTrueTest(){
        val detailsMainActivity = DetailsMainActivity()
        val email:CharSequence = "name@email.com"
        assertTrue(detailsMainActivity.isValidEmail(email))


    }
    @Test
    fun isValidEmailFalseTest(){
        val detailsMainActivity = DetailsMainActivity()
        assertFalse(detailsMainActivity.isValidEmail(""))

    }
}