package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Transaction;
import com.Prana.Latifi.response.TransactionResponse;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

  public static TransactionResponse convert(Transaction transaction) {
    if (transaction == null){
      return null;
    }
    return new TransactionResponse(
        transaction.getId(),
        transaction.getProfile().getFirstName(),
        transaction.getProfile().getLastName(),
        transaction.getProfile().getType(),
        ItemMapper.convertTransactionForm(transaction.getItems()),
        transaction.getCost(),
        transaction.getTransactionDate());
  }

  public static List<TransactionResponse> convertAll(List<Transaction> transactions) {
    List<TransactionResponse> responses = new ArrayList<>();
    for (Transaction transaction : transactions) {
      responses.add(convert(transaction));
    }
    return responses;
  }
}
