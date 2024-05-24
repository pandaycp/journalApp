package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        User user1 = new User();
        user1.setUserName("Govind");
        user1.setPassword("123");

        User user2 = new User();
        user2.setUserName("Radha");
        user2.setPassword("123");

        return Stream.of(
                Arguments.of(user1),
                Arguments.of(user2)
        );
    }
}
