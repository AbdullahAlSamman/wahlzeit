package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.services.EmailServiceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TellFriendTest.class,
        DatastoreAdapterTest.class,
        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        EmailServiceTestSuite.class,
})
public class AllTests {
}
