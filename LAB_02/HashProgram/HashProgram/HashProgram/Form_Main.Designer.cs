namespace HashProgram
{
    partial class Form_Main
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.button = new System.Windows.Forms.Button();
            this.textBox_TextFromFile = new System.Windows.Forms.TextBox();
            this.textBox_HashCode = new System.Windows.Forms.TextBox();
            this.label_TextFromFile = new System.Windows.Forms.Label();
            this.label_HashCode = new System.Windows.Forms.Label();
            this.richTextBox = new System.Windows.Forms.RichTextBox();
            this.label_Binary = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // button
            // 
            this.button.FlatAppearance.BorderSize = 2;
            this.button.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button.Font = new System.Drawing.Font("Comic Sans MS", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.button.Location = new System.Drawing.Point(177, 181);
            this.button.Name = "button";
            this.button.Size = new System.Drawing.Size(130, 40);
            this.button.TabIndex = 0;
            this.button.Text = "Выполнить";
            this.button.UseVisualStyleBackColor = true;
            this.button.Click += new System.EventHandler(this.button_Click);
            // 
            // textBox_TextFromFile
            // 
            this.textBox_TextFromFile.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.textBox_TextFromFile.Location = new System.Drawing.Point(188, 31);
            this.textBox_TextFromFile.Margin = new System.Windows.Forms.Padding(6);
            this.textBox_TextFromFile.Name = "textBox_TextFromFile";
            this.textBox_TextFromFile.ReadOnly = true;
            this.textBox_TextFromFile.Size = new System.Drawing.Size(342, 30);
            this.textBox_TextFromFile.TabIndex = 1;
            this.textBox_TextFromFile.TextChanged += new System.EventHandler(this.textBox_TextFromFile_TextChanged);
            // 
            // textBox_HashCode
            // 
            this.textBox_HashCode.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.textBox_HashCode.Location = new System.Drawing.Point(188, 133);
            this.textBox_HashCode.Margin = new System.Windows.Forms.Padding(6);
            this.textBox_HashCode.Name = "textBox_HashCode";
            this.textBox_HashCode.ReadOnly = true;
            this.textBox_HashCode.Size = new System.Drawing.Size(342, 30);
            this.textBox_HashCode.TabIndex = 2;
            // 
            // label_TextFromFile
            // 
            this.label_TextFromFile.AutoSize = true;
            this.label_TextFromFile.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label_TextFromFile.Location = new System.Drawing.Point(7, 34);
            this.label_TextFromFile.Name = "label_TextFromFile";
            this.label_TextFromFile.Size = new System.Drawing.Size(175, 23);
            this.label_TextFromFile.TabIndex = 3;
            this.label_TextFromFile.Text = "Полученные данные:";
            // 
            // label_HashCode
            // 
            this.label_HashCode.AutoSize = true;
            this.label_HashCode.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label_HashCode.Location = new System.Drawing.Point(61, 133);
            this.label_HashCode.Name = "label_HashCode";
            this.label_HashCode.Size = new System.Drawing.Size(121, 23);
            this.label_HashCode.TabIndex = 4;
            this.label_HashCode.Text = "Хэш-функция:";
            // 
            // richTextBox
            // 
            this.richTextBox.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.richTextBox.Location = new System.Drawing.Point(188, 73);
            this.richTextBox.Margin = new System.Windows.Forms.Padding(6);
            this.richTextBox.Name = "richTextBox";
            this.richTextBox.ReadOnly = true;
            this.richTextBox.Size = new System.Drawing.Size(342, 48);
            this.richTextBox.TabIndex = 5;
            this.richTextBox.Text = "";
            // 
            // label_Binary
            // 
            this.label_Binary.AutoSize = true;
            this.label_Binary.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label_Binary.Location = new System.Drawing.Point(57, 88);
            this.label_Binary.Name = "label_Binary";
            this.label_Binary.Size = new System.Drawing.Size(126, 23);
            this.label_Binary.TabIndex = 6;
            this.label_Binary.Text = "Двоичный код:";
            // 
            // Form_Main
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(204)))), ((int)(((byte)(204)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(542, 263);
            this.Controls.Add(this.label_Binary);
            this.Controls.Add(this.richTextBox);
            this.Controls.Add(this.label_HashCode);
            this.Controls.Add(this.label_TextFromFile);
            this.Controls.Add(this.textBox_HashCode);
            this.Controls.Add(this.textBox_TextFromFile);
            this.Controls.Add(this.button);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form_Main";
            this.Text = "Program";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button;
        private System.Windows.Forms.TextBox textBox_TextFromFile;
        private System.Windows.Forms.TextBox textBox_HashCode;
        private System.Windows.Forms.Label label_TextFromFile;
        private System.Windows.Forms.Label label_HashCode;
        private System.Windows.Forms.RichTextBox richTextBox;
        private System.Windows.Forms.Label label_Binary;
    }
}

