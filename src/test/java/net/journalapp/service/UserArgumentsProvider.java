package net.journalapp.service;

import net.journalapp.entity.UserEntity;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        UserEntity user1 = new UserEntity();
        user1.setUserName("Govind");
        user1.setPassword("123");

        UserEntity user2 = new UserEntity();
        user2.setUserName("Radha");
        user2.setPassword("123");

        return Stream.of(
                Arguments.of(user1),
                Arguments.of(user2)
        );
    }
}
