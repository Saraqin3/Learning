{r}
#split amino acids into different sheets
library(tidyr)
data <- read.csv("Molecule Ratio Results.csv", sep = ",")
data <- separate(data, col = Quantification, into = c("quantification", "unit"), sep = "uM")
data <- separate(data, col = Replicate, into = c("Project", "year", "month", "date", "AA", "PlateNum", "Patient", "Treatment", "Dilution"), sep = "_")
data$unit <- "uM"
data$Final_Concentration <- NA

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
library(ggplot2)
for (i in 1:length(split_data)){
  split_data[[i]]$quantification <- as.numeric(split_data[[i]]$quantification)
  
  for (m in seq_len(nrow(split_data[[i]]))) {
    
    if ((split_data[[i]]$quantification[m]<2.5) | (split_data[[i]]$quantification[m]>750))
    {next}
 
   if (split_data[[i]]$Dilution[m] == "DIL") {
    split_data[[i]]$Final_Concentration[m] <- 10*split_data[[i]]$quantification[m]
   }
    
   else if (split_data[[i]]$Dilution[m] == "UNDIL") {
   split_data[[i]]$Final_Concentration[m] <- 2*split_data[[i]]$quantification[m]
  }
  
      
}
    

    
    
  plot_aa <- as.character(split_data[[i]][2, 1])
  plot_patient <- as.character(split_data[[i]][2, 8])
  combined <- paste (plot_aa, plot_patient)

  categories <- factor(split_data[[i]]$Treatment)
  values <- split_data[[i]]$Final_Concentration

  my_plot <- ggplot(split_data[[i]], aes(x = categories, y = values)) +
  geom_point() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))+
  ggtitle(combined) +
  xlab("Treatment") +
  ylab("Final Quantification uM")
  
  ggsave(filename = paste0(combined, ".png"), plot = my_plot)
  #dev.copy(png, filename = paste0 (combined, ".png"))
  #dev.off() 
  
  
  }

library(writexl) 
write_xlsx(split_data, path = "amino acids split.xlsx")
write_xlsx(split_data_result, path = "amino acids split result.xlsx")




