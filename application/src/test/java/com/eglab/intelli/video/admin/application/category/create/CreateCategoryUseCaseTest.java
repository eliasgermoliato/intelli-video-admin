package com.eglab.intelli.video.admin.application.category.create;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.argThat;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eglab.intelli.video.admin.domain.category.CategoryGateway;

@ExtendWith(MockitoExtension.class)
public class CreateCategoryUseCaseTest {

    @InjectMocks
    private DefaultCreateCategoryUseCase useCase;

    @Mock
    private CategoryGateway categoryGateway;

    @Test
    public void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId() {

        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCommand = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);

        when(categoryGateway.create(Mockito.any())).thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(categoryGateway, times(1)).create(argThat(aCategory -> {
            return Objects.equals(expectedName, aCategory.getName())
                    && Objects.equals(expectedDescription, aCategory.getDescription())
                    && Objects.equals(expectedIsActive, aCategory.isActive()) && Objects.nonNull(aCategory.getId())
                    && Objects.nonNull(aCategory.getCreatedAt()) && Objects.nonNull(aCategory.getUpdatedAt())
                    && Objects.isNull(aCategory.getDeletedAt());
        }));
    }
}
