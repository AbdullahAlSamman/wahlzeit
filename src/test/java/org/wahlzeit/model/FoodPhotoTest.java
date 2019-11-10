package org.wahlzeit.model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.tools.CreateUser;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

public class FoodPhotoTest extends CreateUser {

    protected FoodPhoto testPhoto;

    @ClassRule
    public static RuleChain ruleChain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());

    @Before
    public void startup() {
        FoodPhotoManager.getInstance().init();
    }


    @Test
    public void createFoodPhotoTest() {
        assertNull(testPhoto);
        testPhoto = FoodPhotoFactory.getInstance().createPhoto();
        System.out.println(testPhoto.getId());
        assertNotNull(testPhoto);
    }


}