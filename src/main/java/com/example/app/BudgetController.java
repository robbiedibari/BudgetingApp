package com.example.app;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.List;

public class BudgetController {

        @FXML
        private TableView<Transaction> Table;
        @FXML
        private TableColumn<Transaction, String> nameColumn;
        @FXML
        private TableColumn<Transaction, String> typeColumn;
        @FXML
        private TableColumn<Transaction, Double> amountColumn;
        @FXML
        private TableColumn<Transaction, LocalDate> dateColumn;
        @FXML
        private RadioButton incomeRadioButton;
        @FXML
        private RadioButton expenseRadioButton;
        @FXML
        private TextField categoryField;
        @FXML
        private TextField AmountField;
        @FXML
        private DatePicker DatePicker;
        @FXML
        private PieChart pieChart;
        private VBox rootPane;
        private AnchorPane tablePane;

        private Budget budget;
      //  private DataHandler dataHandler;

        public void initialize() {
            ToggleGroup incomeExpenseGroup = new ToggleGroup();
            this.incomeRadioButton.setToggleGroup(incomeExpenseGroup);
            this.expenseRadioButton.setToggleGroup(incomeExpenseGroup);
            this.incomeRadioButton.setSelected(true); // Set A default value;
            Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));
            amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            typeColumn.setCellFactory(column -> {
                return new TableCell<Transaction, String>() {
                    @Override
                    protected void updateItem(String type, boolean empty) {
                        super.updateItem(type, empty);

                        setText(empty ? "" : getItem().toString());
                        setGraphic(null);

                        if (!isEmpty()) {
                            if (type.equals(Transaction.TransactionType.INCOME.toString())) {
                                setStyle("-fx-background-color: lightgreen");
                            } else if (type.equals(Transaction.TransactionType.EXPENSE.toString())) {
                                setStyle("-fx-background-color: tomato");
                            } else {
                                setStyle("");
                            }
                        }
                    }
                };
            });

          //  dataHandler = new DataHandler();
          //  List<Transaction> transactions = dataHandler.loadData();
            budget = new Budget();
            Table.setItems(budget.getTransactions());


        }

        @FXML
        public void addHandler(ActionEvent actionEvent) {
            String category = categoryField.getText();
            double amount = Double.parseDouble(AmountField.getText());
            LocalDate date = DatePicker.getValue();

            Transaction.TransactionType type;
            if (incomeRadioButton.isSelected()) {
                type = Transaction.TransactionType.INCOME;
            } else {
                type = Transaction.TransactionType.EXPENSE;
            }

            Transaction transaction = new Transaction(category, type, amount, date);
            budget.addTransaction(transaction);
            updatePieChart();
           // dataHandler.saveData(budget.getTransactions());
            clearFields();

        }

        public void clearFields() {
            categoryField.clear();
            AmountField.clear();
            DatePicker.setValue(null);
            incomeRadioButton.setSelected(true);
        }

        @FXML
//        private void clearDataHandler(ActionEvent actionEvent){
//            budget.getTransactions().clear();
//            updatePieChart();
//            clearFields();
//            dataHandler.clearData();
//        }

        private void updatePieChart() {
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Expenses", budget.getTotalExpense()),
                    new PieChart.Data("Income", budget.getTotalIncome())
            );
            
            // Update the chart on the JavaFX application thread
            Platform.runLater(() -> {
                pieChart.setData(pieChartData);

                // Set the color for each slice
                for (PieChart.Data data : pieChart.getData()) {
                    if (data.getName().equals("Expenses")) {
                        data.getNode().setStyle("-fx-pie-color: red;");
                    } else if (data.getName().equals("Income")) {
                        data.getNode().setStyle("-fx-pie-color: green;");
                    }
                }
            });
        }



    }

