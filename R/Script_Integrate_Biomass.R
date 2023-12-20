```{r}

#split amino acids into different sheets
library(tidyr)
library(ggplot2)
library(writexl)
library(readxl)

data <- read.csv("Molecule Ratio Results.csv", sep = ",")
data <- separate(data, col = Quantification, into = c("quantification", "unit"), sep = "uM")
data <- separate(data, col = Replicate, into = c("Project", "year", "month", "date", "AA", "PlateNum", "Patient", "Treatment", "Dilution"), sep = "_")
data$unit <- "uM"
data$Final_Concentration <- NA
data$Symbol <- NA

interactionFactor <- interaction(data$Molecule, data$Patient)
split_data <- split(data, interactionFactor)

split_data_result <- split_data

combined_data <- split_data

for (i in 1:length(split_data)){
 
  split_data[[i]]$quantification <- as.numeric(split_data[[i]]$quantification)
 
  excel_file_path <- "biomass extracted.xlsx"
  bioData <- lapply(excel_sheets(excel_file_path), function(sheet) read_excel(excel_file_path, sheet = sheet))
 
  names(bioData) <- excel_sheets(excel_file_path)
 
  #Locate corresponding biomass sheet
  plateNum <- as.character(split_data[[i]][2, 7])
  plot_patient <- as.character(split_data[[i]][2, 8])
  nameLocate <- paste0(plateNum, plot_patient)
  targetSheet <- bioData[[nameLocate]]
 
  #sheet_names <- names(bioData)
  plot_aa <- as.character(split_data[[i]][2, 1])
  plot_patient <- as.character(split_data[[i]][2, 8])
  combined <- paste (plot_aa, plot_patient)
 
  #Combine 2 data sheets
  combined_data[[i]] <- merge(split_data[[i]], targetSheet, by.x = "Treatment", by.y = "Treatment", all.x = TRUE, all.y = FALSE)
 
  data$Final_Concentration_Biomass <- NA
 
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
      split_data[[i]]$Final_Concentration[m] <- 10*split_data[[i]]$quantification[m]
    }
    else if (split_data[[i]]$Dilution[m] == "UNDIL") {
      split_data[[i]]$Final_Concentration[m] <- 2*split_data[[i]]$quantification[m]
    }
    split_data[[i]]$Final_Concentration_Biomass[m] <- (split_data[[i]]$Final_Concentration[m])/(split_data[[i]]$Biomass_ug[m])
   
  }
 
 
  desired_order <- c("PBS", "AMIOCA", "MSPRE", "LDOGB", "HIMAIZE", "NOVELOSE", "VERSAFIBE", "LACTULOSE", "STACHYOSE", "PULLULAN", "ARABINOXYLAN", "GOS", "INULIN", "FOS", "FOSSIGMA", "KES")
  categories <- factor(split_data[[i]]$Treatment, levels = desired_order)
  background_colors <- c("#FF9999", "#FF9999", "#66B2FF", "#66B2FF", "#66B2FF", "#66B2FF", "#66B2FF", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#99FF99", "#FFCC99", "#FFCC99")
  rect_width <- 0.8
  values <- split_data[[i]]$Final_Concentration_Biomass
  Symbol <- split_data[[i]]$Symbol
  my_plot <- ggplot(split_data[[i]], aes(x = categories, y = values)) +
  geom_rect(aes(fill = categories),
            xmin = as.numeric(categories) - 0.5,
            xmax = as.numeric(categories) + 0.5,
            ymin = -Inf, ymax = Inf, alpha = 0.5) +
  stat_summary(fun = mean, geom = "point", color = "red", size = 3, position = "identity")+
  geom_text(aes(label = Symbol, y=5), vjust = 0, size = 5, color = "black") +

  coord_cartesian(ylim = c(0, 7500))+
  geom_point(alpha = 0) +
  scale_fill_manual(values = background_colors) +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))+
  ggtitle(combined) +
  xlab("Treatment") +
  ylab("Final Quantification uM/Biomass ug")

 
  ggsave(filename = paste0(combined, ".png"), plot = my_plot)
  #dev.copy(png, filename = paste0 (combined, ".png"))
  #dev.off()
}

 
write_xlsx(split_data, path = "amino acids split.xlsx")
write_xlsx(combined_data, path = "split and combined.xlsx")




```
