FROM cassandra:4.1.3

ENV LANG C.UTF-8

COPY scripts/init-cassandra.cql /docker-entrypoint-initdb.d/

COPY scripts/entrypoint.sh /


ENTRYPOINT ["/entrypoint.sh"]
CMD ["cassandra", "-f", "-R"]