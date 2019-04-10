package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.capgemini.bankapp.client.BankAccount;
import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;

public class BankAccountDaoImpl implements BankAccountDao {
	
	JdbcTemplate jdbcTemplate;
	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){
		 this.jdbcTemplate = jdbcTemplate; 
	}


	@Override
	public double getBalance(long accountId) {
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id=" + accountId;
		double balance = -1;
		 
		 

	@Override
	public void updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankaccounts SET account_balance='"+newBalance+"' WHERE account_id='"+accountId+"' ";
		jdbcTemplate.update(query);
		
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		String query = "DELETE FROM bankaccounts WHERE account_id=" + accountId;
		int result=jdbcTemplate.update(query);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public boolean addNewBankAccount(BankAccount account) {

		String query = "INSERT INTO bankaccounts (customer_name,account_type,account_balance) VALUES ('"+account.getAccountHolderName()+"','"+account.getAccountType()+"','"+account.getAccountBalance()+"')";
		int result=jdbcTemplate.update(query);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}


	/*@Override
	public List<BankAccount> findAllBankAccountsDetails() {
		String query = "SELECT * FROM bankaccounts";
		BankAccount account;
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		//Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				account = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDouble(4));
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}*/

	/*@Override
	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException {
		String query = "SELECT * FROM bankaccounts WHERE account_id=" + accountId;
		BankAccount account = null;
		//Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				account = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDouble(4));
			} else {
				throw new AccountNotFoundException("BankAccount doesn't exist....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}*/

	/*@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) {
		String query = "UPDATE bankaccounts SET customer_name=?,account_type=? WHERE account_id=?";
		//Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, accountHolderName);
			statement.setString(2, accountType);
			statement.setLong(3, accountId);
			int result = statement.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}*/

	/*public void commit() {
		try {
			if (connection != null) {
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rollback() {
		try {
			if (connection != null) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

}