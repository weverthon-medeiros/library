/*
 * All materials herein: Copyright (c) 2019 Worldnet TPS Ltd. All Rights Reserved.
 *
 * These materials are owned by Worldnet TPS Ltd and are protected by copyright laws and
 * international copyright treaties, as well as other intellectual property laws and treaties.
 *
 * All right, title and interest in the copyright, confidential information, patents, design rights
 * and all other intellectual property rights of whatsoever nature in and to these materials are and
 * shall remain the sole and exclusive property of Worldnet TPS Ltd.
 */
package my.challenge.library.authorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.challenge.library.authorservice.entity.Author;

/**
 * @author Tom Medeiros 01 May 2019
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
