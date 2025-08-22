package config

import (
	"context"
	"log"

	"github.com/jackc/pgx/v5/pgxpool"
)

func InitDB() *pgxpool.Pool {
	ctx := context.Background()
	connStr := "postgresql://neondb_owner:npg_ZDah7pgSBcF2@ep-frosty-mode-a173e84z-pooler.ap-southeast-1.aws.neon.tech/neondb?sslmode=require"

	dbPool, err := pgxpool.New(ctx, connStr)
	if err != nil {
		log.Fatalf("Failed to create pool: %v", err)
	}

	if err := dbPool.Ping(ctx); err != nil {
		log.Fatalf("Failed to ping Postgres: %v", err)
	}

	log.Println("✅ Connected to Postgres!")
	return dbPool
}
