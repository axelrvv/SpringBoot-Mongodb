package com.org.commerce.springbootcommerce.config;

import com.org.commerce.springbootcommerce.module.Expense;
import com.org.commerce.springbootcommerce.module.ExpenseCategory;
import com.org.commerce.springbootcommerce.repository.ExpenseRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.org.commerce.springbootcommerce.module.ExpenseCategory.*;

@ChangeUnit( id = "seedDatabase",order = "001", author = "Axel")
public class DatabaseChangeLog {

    @Execution
    public void seedDatabase(ExpenseRepository expenseRepository){

        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));

        expenseRepository.insert(expenseList);
    }

    @RollbackExecution
    public void rollback() {

    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount){
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseAmount(amount);
        expense.setExpenseCategory(expenseCategory);

        return expense;
    }

}
