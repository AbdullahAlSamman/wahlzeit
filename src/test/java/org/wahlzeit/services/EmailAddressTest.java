/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

    /**
     *
     */
    public EmailAddressTest(String name) {
        super(name);
    }

    protected EmailAddress emailAddress1 = EmailAddress.EMPTY;
    protected EmailAddress emailAddress2 = EmailAddress.EMPTY;

    @Before
    protected void setup() {
        emailAddress1 = EmailAddress.getFromString("test@test.test");
        emailAddress1.value = "test@test.test";
        emailAddress2 = EmailAddress.getFromString("test@test.test");
        emailAddress2.value = "test@test.test";
    }

    /**
     *
     */
    public void testGetEmailAddressFromString() {
        // invalid email addresses are allowed for local testing and online avoided by Google

        assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
        assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
        assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
        assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
    }

    /**
     *
     */
    protected boolean createEmailAddressIgnoreException(String ea) {
        try {
            EmailAddress.getFromString(ea);
            return true;
        } catch (IllegalArgumentException ex) {
            // creation failed
            Assert.fail();
            return false;
        }
    }

    /**
     *
     */
    public void testEmptyEmailAddress() {
        assertFalse(EmailAddress.EMPTY.isValid());
    }

    @Test
    public void testInstancesIsNotEmpty() {
        assertFalse(EmailAddress.instances.isEmpty());
    }

    @Test
    public void testisEqual() {
        assertTrue(emailAddress1.isEqual(emailAddress2));
    }

    @Test
    public void testisValid() {
        assertFalse(emailAddress1.isValid());
    }

    @Test
    public void testAsString() {
        assertEquals(emailAddress1.asString(), emailAddress2.asString());
    }


}

