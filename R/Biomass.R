



```{r}
#split biomass into different sheets
library(tidyr)
library(writexl)
library(purrr)
library(dplyr)
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
 
  plateNum1 <- as.character(extracted_data1[2, 1])
  patientNum1 <- as.character(extracted_data1[2, 2])
  combined1 <- paste (plateNum1, patientNum1)
  name1 <- combined1
 
  plateNum2 <- as.character(extracted_data2[2, 1])
  patientNum2 <- as.character(extracted_data2[2, 2])
  combined2 <- paste (plateNum2, patientNum2)
  name2 <- combined2
 
  plateNum3 <- as.character(extracted_data3[2, 1])
  patientNum3 <- as.character(extracted_data3[2, 2])
  combined3 <- paste (plateNum3, patientNum3)
  name3 <- combined3
 
  assign(name1, extracted_data1)
  assign(name2, extracted_data2)
  assign(name3, extracted_data3)
 
  split_data_extracted[[combined1]] <- extracted_data1
  split_data_extracted[[combined2]] <- extracted_data2
  split_data_extracted[[combined3]] <- extracted_data3

 
 
}



write_xlsx(split_data_separated, path = "biomass split and separate.xlsx")
write_xlsx(split_data_extracted, path = "biomass extracted.xlsx")




```
