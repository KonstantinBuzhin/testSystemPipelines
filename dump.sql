;             
CREATE USER IF NOT EXISTS "USER" SALT '153caadf6c3b2e3a' HASH '9f51802a9c216da3c2bd6f2dddd776704acf2ecdc7442f4e34d978aabe2e9fd6' ADMIN;       
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_E56ECFFF_C98B_466A_B89F_ED72C3290398" START WITH 3 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."TESTFILES"(
    "IDFILE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_E56ECFFF_C98B_466A_B89F_ED72C3290398" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_E56ECFFF_C98B_466A_B89F_ED72C3290398",
    "FILE" BLOB
); 
ALTER TABLE "PUBLIC"."TESTFILES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("IDFILE");
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.TESTFILES;               
       
