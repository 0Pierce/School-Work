namespace Lab34
{
    partial class SubForm
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
            this.btnSub = new System.Windows.Forms.Button();
            this.btnUnsub = new System.Windows.Forms.Button();
            this.btnCancel = new System.Windows.Forms.Button();
            this.cBoxEmail = new System.Windows.Forms.CheckBox();
            this.cBoxSMS = new System.Windows.Forms.CheckBox();
            this.txtBoxEmail = new System.Windows.Forms.TextBox();
            this.txtBoxSMS = new System.Windows.Forms.TextBox();
            this.lblEmail = new System.Windows.Forms.Label();
            this.lblSMS = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnSub
            // 
            this.btnSub.Location = new System.Drawing.Point(63, 221);
            this.btnSub.Name = "btnSub";
            this.btnSub.Size = new System.Drawing.Size(152, 49);
            this.btnSub.TabIndex = 0;
            this.btnSub.Text = "Subscribe";
            this.btnSub.UseVisualStyleBackColor = true;
            this.btnSub.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnSub_MouseClick);
            // 
            // btnUnsub
            // 
            this.btnUnsub.Location = new System.Drawing.Point(286, 221);
            this.btnUnsub.Name = "btnUnsub";
            this.btnUnsub.Size = new System.Drawing.Size(152, 49);
            this.btnUnsub.TabIndex = 1;
            this.btnUnsub.Text = "Unsuscribe";
            this.btnUnsub.UseVisualStyleBackColor = true;
            this.btnUnsub.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnUnsub_MouseClick);
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(514, 221);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(96, 49);
            this.btnCancel.TabIndex = 2;
            this.btnCancel.Text = "Return";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnCancel_MouseClick);
            // 
            // cBoxEmail
            // 
            this.cBoxEmail.AutoSize = true;
            this.cBoxEmail.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cBoxEmail.Location = new System.Drawing.Point(63, 41);
            this.cBoxEmail.Name = "cBoxEmail";
            this.cBoxEmail.Size = new System.Drawing.Size(208, 24);
            this.cBoxEmail.TabIndex = 3;
            this.cBoxEmail.Text = "Notification Sent by Email";
            this.cBoxEmail.UseVisualStyleBackColor = true;
            this.cBoxEmail.CheckStateChanged += new System.EventHandler(this.cBoxEmail_CheckStateChanged);
            // 
            // cBoxSMS
            // 
            this.cBoxSMS.AutoSize = true;
            this.cBoxSMS.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cBoxSMS.Location = new System.Drawing.Point(63, 105);
            this.cBoxSMS.Name = "cBoxSMS";
            this.cBoxSMS.Size = new System.Drawing.Size(204, 24);
            this.cBoxSMS.TabIndex = 4;
            this.cBoxSMS.Text = "Notification Sent by SMS";
            this.cBoxSMS.UseVisualStyleBackColor = true;
            this.cBoxSMS.CheckStateChanged += new System.EventHandler(this.cBoxSMS_CheckStateChanged);
            // 
            // txtBoxEmail
            // 
            this.txtBoxEmail.Enabled = false;
            this.txtBoxEmail.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtBoxEmail.Location = new System.Drawing.Point(319, 41);
            this.txtBoxEmail.Name = "txtBoxEmail";
            this.txtBoxEmail.Size = new System.Drawing.Size(218, 26);
            this.txtBoxEmail.TabIndex = 5;
            this.txtBoxEmail.Leave += new System.EventHandler(this.txtBoxEmail_Leave);
            // 
            // txtBoxSMS
            // 
            this.txtBoxSMS.Enabled = false;
            this.txtBoxSMS.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtBoxSMS.Location = new System.Drawing.Point(319, 105);
            this.txtBoxSMS.Name = "txtBoxSMS";
            this.txtBoxSMS.Size = new System.Drawing.Size(218, 26);
            this.txtBoxSMS.TabIndex = 6;
            this.txtBoxSMS.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxSMS_KeyPress);
            this.txtBoxSMS.Leave += new System.EventHandler(this.txtBoxSMS_Leave);
            // 
            // lblEmail
            // 
            this.lblEmail.AutoSize = true;
            this.lblEmail.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblEmail.ForeColor = System.Drawing.Color.IndianRed;
            this.lblEmail.Location = new System.Drawing.Point(316, 70);
            this.lblEmail.Name = "lblEmail";
            this.lblEmail.Size = new System.Drawing.Size(89, 18);
            this.lblEmail.TabIndex = 7;
            this.lblEmail.Text = "Invalid Email";
            this.lblEmail.Visible = false;
            // 
            // lblSMS
            // 
            this.lblSMS.AutoSize = true;
            this.lblSMS.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSMS.ForeColor = System.Drawing.Color.IndianRed;
            this.lblSMS.Location = new System.Drawing.Point(316, 134);
            this.lblSMS.Name = "lblSMS";
            this.lblSMS.Size = new System.Drawing.Size(105, 18);
            this.lblSMS.TabIndex = 8;
            this.lblSMS.Text = "Invalid Number";
            this.lblSMS.Visible = false;
            // 
            // SubForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(673, 299);
            this.Controls.Add(this.lblSMS);
            this.Controls.Add(this.lblEmail);
            this.Controls.Add(this.txtBoxSMS);
            this.Controls.Add(this.txtBoxEmail);
            this.Controls.Add(this.cBoxSMS);
            this.Controls.Add(this.cBoxEmail);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnUnsub);
            this.Controls.Add(this.btnSub);
            this.Name = "SubForm";
            this.Text = "SubForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.SubForm_FormClosing);
            this.Load += new System.EventHandler(this.SubForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnSub;
        private System.Windows.Forms.Button btnUnsub;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.CheckBox cBoxEmail;
        private System.Windows.Forms.CheckBox cBoxSMS;
        private System.Windows.Forms.TextBox txtBoxEmail;
        private System.Windows.Forms.TextBox txtBoxSMS;
        private System.Windows.Forms.Label lblEmail;
        private System.Windows.Forms.Label lblSMS;
    }
}