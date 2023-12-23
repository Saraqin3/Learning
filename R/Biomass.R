
```{r}
#split biomass into different sheets
library(tidyr)
library(writexl)
library(purrr)
library(dplyr)
library(readxl)

dataBio <- read.csv("2023_12_07_Biomass Bacterial Pellet_post RapidAIM pH.csv", sep = ",")


split_data <- split(dataBio, dataBio$Participant_ID)

write_xlsx(split_data, path = "biomass split.xlsx")



#Function to separate columns
function_separate_column <- function(df, column_to_separate) {
df_separated <- separate(df, column_to_separate,
into = c("Plate_ID1", "Plate_ID2", "Plate_ID3"), sep = "_")
return(df_separated)
}


# Apply the function to each data frame in the list
split_data_separated <- map(split_data, ~ function_separate_column(.x, column_to_separate = "Plate_ID"))

columns_to_extract1 <- c("Plate_ID1", "Participant_ID", "Compound_Set1", "Bacterial_Pellet_ug_Set1", "pH_Set1")
columns_to_extract2 <- c("Plate_ID2", "Participant_ID", "Compound_Set2", "Bacterial_Pellet_ug_Set2", "pH_Set2")
columns_to_extract3 <- c("Plate_ID3", "Participant_ID", "Compound_Set3", "Bacterial_Pellet_ug_Set3", "pH_Set3")

split_data_extracted <- list()

for (i in 1:length(split_data_separated)){
 
  extracted_data1 <- split_data_separated[[i]] %>% select(all_of(columns_to_extract1))
  extracted_data2 <- split_data_separated[[i]] %>% select(all_of(columns_to_extract2))
  extracted_data3 <- split_data_separated[[i]] %>% select(all_of(columns_to_extract3))
 
  colnames(extracted_data1)[3] <- "Treatment"
  colnames(extracted_data2)[3] <- "Treatment"
  colnames(extracted_data3)[3] <- "Treatment"
 
  colnames(extracted_data1)[4] <- "Biomass_ug"
  colnames(extracted_data2)[4] <- "Biomass_ug"
  colnames(extracted_data3)[4] <- "Biomass_ug"
 
  plateNum1 <- as.character(extracted_data1[2, 1])
  patientNum1 <- as.character(extracted_data1[2, 2])
  combined1 <- paste0 (plateNum1, patientNum1)
  name1 <- paste("P", combined1, sep = "")
 
  plateNum2 <- as.character(extracted_data2[2, 1])
  patientNum2 <- as.character(extracted_data2[2, 2])
  combined2 <- paste0 (plateNum2, patientNum2)
  name2 <- paste("P", combined2, sep = "")
 
  plateNum3 <- as.character(extracted_data3[2, 1])
  patientNum3 <- as.character(extracted_data3[2, 2])
  combined3 <- paste0 (plateNum3, patientNum3)
  name3 <- paste("P", combined3, sep = "")
 
  assign(name1, extracted_data1)
  assign(name2, extracted_data2)
  assign(name3, extracted_data3)
 
  split_data_extracted[[name1]] <- extracted_data1
  split_data_extracted[[name2]] <- extracted_data2
  split_data_extracted[[name3]] <- extracted_data3

}

excel_file_path <- "V49.xlsx"
v49Data <- lapply(excel_sheets(excel_file_path), function(sheet) read_excel(excel_file_path, sheet = sheet))

names(v49Data) <- excel_sheets(excel_file_path)
joinedFile <- c(split_data_extracted, v49Data)


write_xlsx(split_data_separated, path = "biomass split and separate.xlsx")
write_xlsx(split_data_extracted, path = "biomass extracted.xlsx")
write_xlsx(joinedFile, path = "biomass joined.xlsx")




```

