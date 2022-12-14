PGDMP                     
    z            scrapDB    10.23    10.23     ?
           0    0    ENCODING    ENCODING     #   SET client_encoding = 'SQL_ASCII';
                       false            ?
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ?
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            ?
           1262    16393    scrapDB    DATABASE     ?   CREATE DATABASE "scrapDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE "scrapDB";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ?
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            ?
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    16474    acceptanceScrap    TABLE     ?  CREATE TABLE public."acceptanceScrap" (
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
 %   DROP TABLE public."acceptanceScrap";
       public         postgres    false    3            ?            1259    16472 !   acceptanceScrap_acceptance_id_seq    SEQUENCE     ?   ALTER TABLE public."acceptanceScrap" ALTER COLUMN acceptance_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."acceptanceScrap_acceptance_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    3    198            ?            1259    16423 	   user_list    TABLE     ?   CREATE TABLE public.user_list (
    id integer NOT NULL,
    user_name character varying(20) NOT NULL,
    user_password character varying(25),
    access_type integer
);
    DROP TABLE public.user_list;
       public         postgres    false    3            ?            1259    16482    user_list_id_seq    SEQUENCE     ?   ALTER TABLE public.user_list ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_list_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    196    3            ?
          0    16474    acceptanceScrap 
   TABLE DATA               ?   COPY public."acceptanceScrap" (acceptance_id, supplier, gross_weight, container_weight, net_weight, price_per_kg, total_payment, acceptor, acceptance_date) FROM stdin;
    public       postgres    false    198          ?
          0    16423 	   user_list 
   TABLE DATA               N   COPY public.user_list (id, user_name, user_password, access_type) FROM stdin;
    public       postgres    false    196   ,       ?
           0    0 !   acceptanceScrap_acceptance_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."acceptanceScrap_acceptance_id_seq"', 12, true);
            public       postgres    false    197            ?
           0    0    user_list_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_list_id_seq', 4, true);
            public       postgres    false    199            x
           2606    16478 $   acceptanceScrap acceptanceScrap_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public."acceptanceScrap"
    ADD CONSTRAINT "acceptanceScrap_pkey" PRIMARY KEY (acceptance_id);
 R   ALTER TABLE ONLY public."acceptanceScrap" DROP CONSTRAINT "acceptanceScrap_pkey";
       public         postgres    false    198            v
           2606    16427    user_list user_list_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.user_list
    ADD CONSTRAINT user_list_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.user_list DROP CONSTRAINT user_list_pkey;
       public         postgres    false    196            ?
     x?}?An!E??.??1ܥ?I?.?ɪ]T???"E?2͜?ܨ?jF*?|?|?/9?%??A>u??(?L??ZHE?ZF@[?C??e?3?%? n0K???N??&W???1ܟ ?3??#_?Mm?۶??d????
?5?w??? ??>(?A???????Z{??8?T?b)?X¢a?w???E/?ӯ?q???ǡ.<7??}???D?
??
Ą;?&????)???B*?D??r?ٯ ?e?-W+!z??H?ek???U#b      ?
   !   x?3?LL??̃??\Ɯ?ũE+F??? ?s	K     