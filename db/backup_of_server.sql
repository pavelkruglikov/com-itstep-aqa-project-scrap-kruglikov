--
-- PostgreSQL database cluster dump
--

-- Started on 2022-11-21 12:59:54

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md57c6b8a647f2b43dbf7c4b84b1aad8df9';






--
-- Database creation
--

CREATE DATABASE "scrapDB" WITH TEMPLATE = template0 OWNER = postgres;
REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 10.23
-- Dumped by pg_dump version 10.23

-- Started on 2022-11-21 12:59:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2792 (class 0 OID 0)
-- Dependencies: 2791
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2794 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2795 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


-- Completed on 2022-11-21 12:59:54

--
-- PostgreSQL database dump complete
--

\connect "scrapDB"

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 10.23
-- Dumped by pg_dump version 10.23

-- Started on 2022-11-21 12:59:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2813 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16474)
-- Name: acceptanceScrap; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."acceptanceScrap" (
    acceptance_id integer NOT NULL,
    supplier character varying(20) NOT NULL,
    gross_weight double precision NOT NULL,
    container_weight double precision,
    net_weight double precision NOT NULL,
    price_per_kg double precision NOT NULL,
    total_payment double precision NOT NULL,
    acceptor character varying(20) NOT NULL,
    acceptance_date character varying
);


ALTER TABLE public."acceptanceScrap" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16472)
-- Name: acceptanceScrap_acceptance_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."acceptanceScrap" ALTER COLUMN acceptance_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."acceptanceScrap_acceptance_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 196 (class 1259 OID 16423)
-- Name: user_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_list (
    id integer NOT NULL,
    user_name character varying(20) NOT NULL,
    user_password character varying(25),
    access_type integer
);


ALTER TABLE public.user_list OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16482)
-- Name: user_list_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.user_list ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_list_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2804 (class 0 OID 16474)
-- Dependencies: 198
-- Data for Name: acceptanceScrap; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."acceptanceScrap" (acceptance_id, supplier, gross_weight, container_weight, net_weight, price_per_kg, total_payment, acceptor, acceptance_date) FROM stdin;
6	ТверьМеталл	18000	12000	6000	18	108000	Иванов	2022-11-17
5	МеталлПрофиль	6000	3000	3000	14	42000	Иванов	2022-11-17
3	ТверьМеталл	25000	15000	10000	15	150000	Иванов	2022-11-17
8	Металлист	25500	14530	10970	16	175520	Иванов	2022-11-17
9	МеталлоБаза	60000	30000	30000	16	480000	Петров	2022-11-18
4	ЗаменаМеталл	15000	4000	11000	15	165000	Заменкин	2022-11-17
11	ТверьМеталл	12244	7000	5244	17	89148	Иванов	2022-11-19
10	Металлист	12222	3443	8779	17	149243	Иванов	2022-11-19
12	МеталлПрофиль	22030	17000	5030	17	85510	Иванов	2022-11-19
\.


--
-- TOC entry 2802 (class 0 OID 16423)
-- Dependencies: 196
-- Data for Name: user_list; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_list (id, user_name, user_password, access_type) FROM stdin;
2	admin	admin	1
3	user	user	2
\.


--
-- TOC entry 2814 (class 0 OID 0)
-- Dependencies: 197
-- Name: acceptanceScrap_acceptance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."acceptanceScrap_acceptance_id_seq"', 12, true);


--
-- TOC entry 2815 (class 0 OID 0)
-- Dependencies: 199
-- Name: user_list_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_list_id_seq', 4, true);


--
-- TOC entry 2680 (class 2606 OID 16478)
-- Name: acceptanceScrap acceptanceScrap_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."acceptanceScrap"
    ADD CONSTRAINT "acceptanceScrap_pkey" PRIMARY KEY (acceptance_id);


--
-- TOC entry 2678 (class 2606 OID 16427)
-- Name: user_list user_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_list
    ADD CONSTRAINT user_list_pkey PRIMARY KEY (id);


-- Completed on 2022-11-21 12:59:55

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 10.23
-- Dumped by pg_dump version 10.23

-- Started on 2022-11-21 12:59:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2791 (class 0 OID 0)
-- Dependencies: 2790
-- Name: DATABASE template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2793 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


-- Completed on 2022-11-21 12:59:55

--
-- PostgreSQL database dump complete
--

-- Completed on 2022-11-21 12:59:55

--
-- PostgreSQL database cluster dump complete
--

