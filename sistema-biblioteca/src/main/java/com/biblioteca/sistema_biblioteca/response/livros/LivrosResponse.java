package com.biblioteca.sistema_biblioteca.response.livros;

import com.biblioteca.sistema_biblioteca.models.ModelsLivros;
import com.biblioteca.sistema_biblioteca.utils.CommonResponse;
import com.biblioteca.sistema_biblioteca.utils.HttpStatusConstants;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class LivrosResponse {

        public static CommonResponse<?> created(ModelsLivros modelsLivros) {
            return CommonResponse.builder()
                    .result(modelsLivros)
                    .error(Boolean.FALSE)
                    .status(HttpStatusConstants.HTTP_CREATED.CODE)
                    .message(HttpStatusConstants.HTTP_CREATED.DESCRIPTION)
                    .detailMessage("Created client id: " + modelsLivros.getId())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build();
        }

        public static CommonResponse<?> updated(ModelsLivros modelsLivros) {
            return CommonResponse.builder()
                    .result(modelsLivros)
                    .error(Boolean.FALSE)
                    .status(HttpStatusConstants.HttpOK.CODE)
                    .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                    .detailMessage("Updated livro id: " + modelsLivros.getId())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build();
        }

        public static CommonResponse<?> founded(ModelsLivros modelsLivros) {
            return CommonResponse.builder()
                    .result(modelsLivros)
                    .error(Boolean.FALSE)
                    .status(HttpStatusConstants.HttpOK.CODE)
                    .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                    .detailMessage("Query performed successfully!")
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build();
        }

        public static CommonResponse<?> founded(Page<ModelsLivros> modelsLivrosPage) {
            return CommonResponse.builder()
                    .result(modelsLivrosPage)
                    .error(Boolean.FALSE)
                    .status(HttpStatusConstants.HttpOK.CODE)
                    .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                    .detailMessage("Query performed successfully")
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build();
        }

        public static CommonResponse<?> ok() {
            return CommonResponse.builder()
                    .error(Boolean.FALSE)
                    .status(HttpStatusConstants.HttpOK.CODE)
                    .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                    .detailMessage("Accepted.")
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build();
        }

        public static CommonResponse<?> ok(Object object) {
            return CommonResponse.builder()
                    .result(object)
                    .error(Boolean.FALSE)
                    .status(HttpStatusConstants.HttpOK.CODE)
                    .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                    .detailMessage("Accepted.")
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build();
        }
    }
