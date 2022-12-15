CREATE TABLE IF NOT EXISTS MEMBER
(
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    name     VARCHAR(45) NOT NULL,
    email    VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS POST
(
    id           BIGINT      NOT NULL AUTO_INCREMENT,
    sentence     TEXT        NOT NULL,
    title        VARCHAR(45) NOT NULL,
    date         DATETIME    NOT NULL,
    member_id_fk BIGINT      NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_post_member_idx (member_id_fk ASC) VISIBLE,
    CONSTRAINT fk_post_member
        FOREIGN KEY (member_id_fk)
            REFERENCES MEMBER (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS POST_LIKE
(
    id           BIGINT NOT NULL AUTO_INCREMENT,
    post_id_fk   BIGINT NOT NULL,
    member_id_fk BIGINT NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_like_post1_idx (post_id_fk ASC) VISIBLE,
    INDEX fk_like_member1_idx (member_id_fk ASC) VISIBLE,
    CONSTRAINT fk_like_post1
        FOREIGN KEY (post_id_fk)
            REFERENCES POST (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_like_member1
        FOREIGN KEY (member_id_fk)
            REFERENCES MEMBER (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS COMMENT
(
    id           BIGINT   NOT NULL AUTO_INCREMENT,
    sentence     TEXT     NOT NULL,
    date         DATETIME NOT NULL,
    member_id_fk BIGINT   NOT NULL,
    post_id_fk   BIGINT   NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_comment_member1_idx (member_id_fk ASC) VISIBLE,
    INDEX fk_comment_post1_idx (post_id_fk ASC) VISIBLE,
    CONSTRAINT fk_comment_member1
        FOREIGN KEY (member_id_fk)
            REFERENCES MEMBER (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_comment_post1
        FOREIGN KEY (post_id_fk)
            REFERENCES POST (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS COMMENT_LIKE
(
    id            BIGINT NOT NULL AUTO_INCREMENT,
    comment_id_fk BIGINT NOT NULL,
    member_id_fk  BIGINT NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_comment_like_comment1_idx (comment_id_fk ASC) VISIBLE,
    INDEX fk_comment_like_member1_idx (member_id_fk ASC) VISIBLE,
    CONSTRAINT fk_comment_like_comment1
        FOREIGN KEY (comment_id_fk)
            REFERENCES COMMENT (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_comment_like_member1
        FOREIGN KEY (member_id_fk)
            REFERENCES MEMBER (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS HASHTAG
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    category   VARCHAR(45) NOT NULL,
    post_id_fk BIGINT      NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_HASHTAG_POST1_idx (post_id_fk ASC) VISIBLE,
    CONSTRAINT fk_HASHTAG_POST1
        FOREIGN KEY (post_id_fk)
            REFERENCES POST (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
