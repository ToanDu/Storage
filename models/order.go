package models

import (
	"context"

	"github.com/google/uuid"
	"github.com/jackc/pgx/v5/pgxpool"
)

type Order struct {
	ID        uuid.UUID
	TxnRef    string
	Amount    int64
	OrderInfo string
	Status    string
}

func CreateOrder(db *pgxpool.Pool, txnRef string, amount int64, info string) error {
	_, err := db.Exec(context.Background(),
		"INSERT INTO orders (id, txn_ref, amount, order_info, status) VALUES ($1, $2, $3, $4, 'pending')",
		uuid.New(), txnRef, amount, info)
	return err
}

func UpdateOrderStatus(db *pgxpool.Pool, txnRef, status string) error {
	_, err := db.Exec(context.Background(),
		"UPDATE orders SET status=$1 WHERE txn_ref=$2", status, txnRef)
	return err
}
