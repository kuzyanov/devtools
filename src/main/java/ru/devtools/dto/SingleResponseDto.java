package ru.devtools.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

/** @author Stepan_Kuzyanov */
@Value
@AllArgsConstructor(staticName = "of")
public class SingleResponseDto<T> {

  T data;
}
