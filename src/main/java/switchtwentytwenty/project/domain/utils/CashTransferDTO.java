package switchtwentytwenty.project.domain.utils;

import java.util.Date;

public class CashTransferDTO {

        private String originFamilyMemberCC;
        private String destinationFamilyMemberCC;
        //private int accountID;
        private double transferedValue; //Currency ?
        private int categoryID;
        private String transactionDesignation;
        private Date transactionDate;


        public CashTransferDTO(String originFamilyMemberCC, String destinationFamilyMemberCC, double transferedValue, int categoryID, String transactionDesignation, Date transactionDate) {
            this.originFamilyMemberCC = originFamilyMemberCC;
            this.destinationFamilyMemberCC = destinationFamilyMemberCC;
            this.transferedValue = transferedValue;
            this.categoryID = categoryID;
            this.transactionDesignation = transactionDesignation;
            this.transactionDate = (Date) transactionDate.clone();
        }

        public String getOriginFamilyMemberCC() {return originFamilyMemberCC;}

        public String getDestinationFamilyMemberCC() {return destinationFamilyMemberCC;}

        public double getTransferedValue() {
            return transferedValue;
        }

        public int getCategoryID() {
            return categoryID;
        }

        public String getTransactionDesignation() {
            return transactionDesignation;
        }

        public Date getTransactionDate() {
            return (Date) transactionDate.clone();
        }

    }


