```{r}

#split amino acids into different sheets
library(tidyr)
library(ggplot2)
library(writexl)
library(readxl)
library(openxlsx)

data <- read.csv("Molecule Ratio Results.csv", sep = ",")
data <- separate(data, col = Quantification, into = c("quantification", "unit"), sep = "uM")
data <- separate(data, col = Replicate, into = c("Project", "year", "month", "date", "AA", "PlateNum", "Patient", "Treatment", "Dilution"), sep = "_")
data$unit <- "uM"
data$Final_Mass_nmol <- NA
data$Symbol <- NA

interactionFactor <- interaction(data$Molecule, data$Patient)
split_data <- split(data, interactionFactor)



excel_file_path <- "biomass joined.xlsx"
bioData <- lapply(excel_sheets(excel_file_path), function(sheet) read_excel(excel_file_path, sheet = sheet))
 
names(bioData) <- excel_sheets(excel_file_path)

excel_file_path2 <- "Baseline split.xlsx"
baselineData <- lapply(excel_sheets(excel_file_path2), function(sheet) read_excel(excel_file_path2, sheet = sheet))

names(baselineData) <- excel_sheets(excel_file_path2)

for (i in 1:length(split_data)){
 
  split_data[[i]]$quantification <- as.numeric(split_data[[i]]$quantification)
 
  #Locate corresponding biomass sheet
  plateNum <- as.character(split_data[[i]][2, 7])
  plot_patient <- as.character(split_data[[i]][2, 8])
  nameLocate <- paste0(plateNum, plot_patient)
  targetSheet <- bioData[[nameLocate]]
 
  #Locate corresponding baseline sheet
  plot_aa <- as.character(split_data[[i]][2, 1])
  targetSheetBaseline <- baselineData[[plot_aa]]
 
  #sheet_names <- names(bioData)
 
  plot_patient <- as.character(split_data[[i]][2, 8])
  combined <- paste (plot_aa, plot_patient)
 
 
 
  #Copy Treatment column and name it as TreatmentClean
  treatment_column_index <- which(colnames(split_data[[i]]) == "Treatment")
  split_data[[i]] <- cbind(split_data[[i]][, 1:treatment_column_index], "", split_data[[i]][, (treatment_column_index + 1):ncol(split_data[[i]])])
 
  TreatmentClean_index <- treatment_column_index + 1
  #print(TreatmentClean_index)
  split_data[[i]][, treatment_column_index + 1] <- split_data[[i]][, treatment_column_index]
  colnames(split_data[[i]])[TreatmentClean_index] <- "TreatmentClean"
 
  #print(split_data[[i]]$TreatmentClean)
 
 
   for (m in seq_len(nrow(split_data[[i]]))) {
     
     if (split_data[[i]]$quantification[m]<1)
     {
       split_data[[i]]$Symbol[m] <- "-"
     }
     else if (split_data[[i]]$quantification[m]>750)
     {
       split_data[[i]]$Symbol[m] <- "+"
     }
     else if (split_data[[i]]$Dilution[m] == "DIL") {
       split_data[[i]]$Final_Mass_nmol[m] <- 10*split_data[[i]]$quantification[m]/1.1
     }
     else if (split_data[[i]]$Dilution[m] == "UNDIL") {
       split_data[[i]]$Final_Mass_nmol[m] <- 2*split_data[[i]]$quantification[m]/1.1
     }
     
     cell_value <- split_data[[i]][m, TreatmentClean_index]

    # Check the condition and update the cell value
    if (cell_value == "PBS2")
    {split_data[[i]][m, TreatmentClean_index] <- "PBS"}
    else if (cell_value == "PBS3")
    {split_data[[i]][m, TreatmentClean_index] <- "PBS"}
    else if (cell_value == "INULIN2")
    {split_data[[i]][m, TreatmentClean_index] <- "INULIN"}
    else if (cell_value == "INULINCHEM")
    {split_data[[i]][m, TreatmentClean_index] <- "INULIN"}
    else if (cell_value == "FOSSIGMA")
    {split_data[[i]][m, TreatmentClean_index] <- "FOS"}

   

  }
 
  #Combine baseline
  split_data[[i]] <- merge(split_data[[i]], targetSheetBaseline, by.x = "TreatmentClean", by.y = "Treatment", all.x = TRUE, all.y = FALSE)
 
   split_data[[i]]$After_substract_baseline_nmol <- NA
 
  #Combine 2 data sheets biomass
  split_data[[i]] <- merge(split_data[[i]], targetSheet, by.x = "Treatment", by.y = "Treatment", all.x = TRUE, all.y = FALSE)
 
  split_data[[i]]$Final_Concentration_Biomass_nmol_per_ug <- NA
 
  for (m in seq_len(nrow(split_data[[i]]))) {
     split_data[[i]]$After_substract_baseline_nmol[m] <-
       (split_data[[i]]$Final_Mass_nmol[m]-split_data[[i]]$Baseline_nmol_post_RapidAIM[m])
   
    split_data[[i]]$Final_Concentration_Biomass_nmol_per_ug[m] <- (split_data[[i]]$After_substract_baseline_nmol[m])/(split_data[[i]]$Biomass_ug[m])
     
   
  }
 
  desired_order <- c("PBS", "AMIOCA", "MSPRE", "LDOGB", "HIMAIZE", "NOVELOSE", "VERSAFIBE", "LACTULOSE", "STACHYOSE", "PULLULAN", "ARABINOXYLAN", "GOS", "INULIN", "FOS", "FOSSIGMA", "KES")
  categories <- factor(split_data[[i]]$Treatment, levels = desired_order)
  background_colors <- c("#FF9999", "#FF9999", "#66B2FF", "#66B2FF", "#66B2FF", "#66B2FF", "#66B2FF", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#FFCC99", "#FFCC99")
  rect_width <- 0.8
  values <- split_data[[i]]$Final_Concentration_Biomass_nmol_per_ug
  Symbol <- split_data[[i]]$Symbol
  my_plot <- ggplot(split_data[[i]], aes(x = categories, y = values)) +
  geom_rect(aes(fill = categories),
            xmin = as.numeric(categories) - 0.5,
            xmax = as.numeric(categories) + 0.5,
            ymin = -Inf, ymax = Inf, alpha = 0.5) +
  stat_summary(fun = mean, geom = "point", color = "red", size = 3, position = "identity")+
  geom_text(aes(label = Symbol, y=5), vjust = 0, size = 5, color = "black") +

  #coord_cartesian(ylim = c(0, 7500))+
  geom_point(alpha = 0) +
  scale_fill_manual(values = background_colors) +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))+
  ggtitle(combined) +
  xlab("Treatment") +
  ylab("Final Quantification nmol/Biomass ug")

 
  ggsave(filename = paste0(combined, ".png"), plot = my_plot)
  #dev.copy(png, filename = paste0 (combined, ".png"))
  #dev.off()
}


 
write_xlsx(split_data, path = "amino acids split.xlsx")





```