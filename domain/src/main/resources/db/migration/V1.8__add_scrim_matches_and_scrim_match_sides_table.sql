create table scrimmers.scrim_matches
(
  id          varchar(13) not null
    primary key,
  scrim_id    varchar(13) not null,
  winner_side varchar(10) not null,
  `order`     int not null,
  pog_user_id varchar(13) null,
  deleted     bit         not null,
  created_at  datetime    not null,
  updated_at  datetime    not null,
  constraint scrim_matches_scrims_id_fk
    foreign key (scrim_id) references scrimmers.scrims (id)
) comment '스크림 매치 테이블';

create table scrimmers.scrim_matches_histories
(
  id            varchar(13) not null,
  revision_id   bigint      not null,
  revision_type tinyint     not null,
  scrim_id      varchar(13) not null,
  winner_side   varchar(10) not null,
  `order`     int not null,
  pog_user_id varchar(13) null,
  deleted       bit         not null,
  created_at    datetime    not null,
  updated_at    datetime    not null,
  primary key (id, revision_id)
) comment '스크림 매치 내역 테이블';

create table scrim_match_sides
(
  id             varchar(13) not null
    primary key,
  scrim_match_id varchar(13) not null,
  team_type varchar(10) not null,
  side           varchar(10) not null,
  kill_score     int         not null,
  total_gold     int         not null,
  deleted        bit         not null,
  created_at     datetime    not null,
  updated_at     datetime    not null,
  constraint scrim_match_sides_scrim_matches_id_fk
    foreign key (scrim_match_id) references scrim_matches (id)
) comment '스크림 매치 정보 테이블';

create table scrim_match_sides_histories
(
  id             varchar(13) not null,
  revision_id    bigint      not null,
  revision_type  tinyint     not null,
  scrim_match_id varchar(13) not null,
  team_type varchar(10) not null,
  side           varchar(10) not null,
  kill_score     int         not null,
  total_gold     int         not null,
  deleted        bit         not null,
  created_at     datetime    not null,
  updated_at     datetime    not null,
  primary key (id, revision_id)
) comment '스크림 매치 정보 내역 테이블';
