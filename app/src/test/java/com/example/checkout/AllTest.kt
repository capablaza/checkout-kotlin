package com.example.checkout

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(CardTest::class, SummaryTest::class, CheckoutTest::class)
class AllTest {
}