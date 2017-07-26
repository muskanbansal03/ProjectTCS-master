package com.example.keshav.projecttcs;

import android.provider.BaseColumns;

/**
 * Created by muskan on 17-07-2017.
 */

public class BeneficiaryContract {

    public static final class BeneficiaryEntry implements BaseColumns {

        public static final String TABLE_NAME = "beneficiary";
        public static final String COLUMN_BENEFICIARY_NAME = "beneficiary_name";
        public static final String COLUMN_BENEFICIARY_EMAIL = "beneficiary_email";
        public static final String COLUMN_BENEFICIARY_ADDRESS = "beneficiary_city";
       // public static final String COLUMN_BENEFICIARY_COUNTRY = "beneficiary_country";
    }
}
