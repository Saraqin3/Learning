{r}
#split amino acids into different sheets
library(tidyr)
data <- read.csv("Molecule Ratio Results.csv", sep = ",")
data <- separate(data, col = Quantification, into = c("quantification", "unit"), sep = "uM")
data <- separate(data, col = Replicate, into = c("Project", "year", "month", "date", "AA", "PlateNum", "Patient", "Treatment", "Dilution"), sep = "_")
data$unit <- "uM"

interactionFactor <- interaction(data$Molecule, data$Patient)
print(interactionFactor)
split_data <- split(data, interactionFactor)



                   
length(split_data)

split_data_result <- split_data

#for (i in 1:length(split_data)){
  #a <- split_data[[i]]
  #b <- a %>% dplyr::select(Molecule, Replicate, quantification, unit)
  #all_sd <- a$Analyte.Concentration[a$Exclude.From.Calibration == "False"] %>% na.omit()
  #b$SD_range <- paste0(min(all_sd),"-",max(all_sd))
  #b$quantification <- as.numeric(b$quantification)
  #b$`out of linear range` <- ifelse(b$quantification < min(all_sd)*0.8 | b$quantification > max(all_sd)*1.5, "*", "")
  #split_data_result[[i]] <- b
  
#}

for (i in 1:length(split_data)){
  plot_aa <- as.character(split_data[[i]][2, 1])
  plot_patient <- as.character(split_data[[i]][2, 8])
  combined <- paste (plot_aa, plot_patient)

  
  plot(split_data[[i]]$Treatment, split_data[[i]]$quantification, main=combined, xlab="Different Treatments", ylab="Quantification")
  dev.copy(png, filename = paste0 (combined, ".png"))
  dev.off() 
}

library(writexl) 
write_xlsx(split_data, path = "amino acids split.xlsx")
write_xlsx(split_data_result, path = "amino acids split result.xlsx")

write.csv(data, file = "test.csv")