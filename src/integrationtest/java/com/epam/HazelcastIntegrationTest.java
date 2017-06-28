package com.epam;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.junit.After;
import org.junit.Before;

public class HazelcastIntegrationTest {
    @Before
    public void setUp() throws Exception {
        final HazelcastInstance instance = Hazelcast.newHazelcastInstance();
    }

    @After
    public void tearDown() throws Exception {
        Hazelcast.shutdownAll();
    }
}
