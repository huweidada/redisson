/**
 * Copyright (c) 2013-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.redisson.config.Config;
import org.springframework.beans.factory.BeanFactory;

/**
 * Configuration for RExecutorService workers.
 * 
 * @author Nikita Koksharov
 *
 */
public final class WorkerOptions {

    private int workers = 1;
    private ExecutorService executorService;
    private BeanFactory beanFactory;
    private long taskTimeout;
    
    private WorkerOptions() {
    }
    
    public static WorkerOptions defaults() {
        return new WorkerOptions();
    }
    
    public int getWorkers() {
        return workers;
    }

    /**
     * Defines workers amount used to execute tasks.
     * Default is <code>1</code>.
     * 
     * @param workers - workers amount
     * @return self instance
     */
    public WorkerOptions workers(int workers) {
        this.workers = workers;
        return this;
    }
    
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    
    /**
     * Defines Spring BeanFactory instance to execute tasks with Spring's '@Autowired', 
     * '@Value' or JSR-330's '@Inject' annotation.
     * 
     * @param beanFactory - Spring BeanFactory instance
     * @return self instance
     */
    public WorkerOptions beanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        return this;
    }
    
    public ExecutorService getExecutorService() {
        return executorService;
    }
    
    /**
     * Defines custom ExecutorService to execute tasks.
     * {@link Config#setExecutor(ExecutorService)} is used by default.
     * 
     * @param executorService - custom ExecutorService
     * @return self instance
     */
    public WorkerOptions executorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    /**
     * Defines task timeout since moment of task execution start
     *
     * @param timeout
     * @param unit
     * @return
     */
    public WorkerOptions taskTimeout(long timeout, TimeUnit unit) {
        this.taskTimeout = unit.toMillis(timeout);
        return this;
    }

    public long getTaskTimeout() {
        return taskTimeout;
    }

}
