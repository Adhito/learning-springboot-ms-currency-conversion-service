package com.learningspringbootms.mscurrencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learningspringbootms.mscurrencyconversionservice.entity.CurrencyConversion;

@FeignClient(name = "ms-currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retreiveExchangeValue(@PathVariable String from, @PathVariable String to);
}
