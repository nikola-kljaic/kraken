package com.kraken.runtime.docker.env;

import com.google.common.collect.ImmutableMap;
import com.kraken.runtime.client.properties.RuntimeClientProperties;
import com.kraken.runtime.entity.ExecutionContext;
import com.kraken.runtime.entity.TaskType;
import com.kraken.tools.environment.KrakenEnvironmentKeys;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.kraken.tools.environment.KrakenEnvironmentKeys.KRAKEN_RUNTIME_URL;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class RuntimeUrlPublisher implements EnvironmentPublisher {

  @NonNull RuntimeClientProperties properties;

  @Override
  public boolean test(final TaskType taskType) {
    return true;
  }

  @Override
  public Map<String, String> apply(final ExecutionContext context) {
    return ImmutableMap.of(KRAKEN_RUNTIME_URL, properties.getRuntimeUrl());
  }
}
